package sample;

import java.io.CharArrayReader;
import java.nio.ByteBuffer;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Oxana on 22.02.2016.
 */
public class FastConversion {

    int sumCount = 0;
    int mulCount = 0;
    int N = 16;

    public Double[] getFunction(){
        Double[] array = new Double[N];
        for(int i = 0; i < N; i++) {
            array[i] = (Math.cos(4 * Math.PI * i / N) + Math.sin(2 * Math.PI * i / N));
         //   System.out.println(array.get(i));
        }
        return array ;
    }

    public Double[] fastWalshTransform(Double[] variables, int sign ) {
        int n = variables.length;

        if (n == 1) {
            return variables;
        }

        Double[] b = new Double[n / 2];
        Double[] c = new Double[n / 2];

        for (int i = 0; i < n / 2; i++) {
            b[i] = variables[i] + variables[i + n / 2];
            c[i] = variables[i] - variables[i + n / 2];
            sumCount ++;
        }

        Double[] left = fastWalshTransform(b, sign);
        Double[] right = fastWalshTransform(c, sign);

        Double[] result = new Double[n];
        if(sign > 0) {
            for(int i = 0; i < n / 2; i++) {
                result[i] = left[i] / 2;
                result[i + n/2] = right[i] / 2;
            }
        }
        else {
            for(int i = 0; i < n / 2; i++) {
                result[i] = left[i];
                result[i + n/2] = right[i];
            }
        }
        return result;
    }

    int getSumCount(){
        return sumCount;
    }
}
