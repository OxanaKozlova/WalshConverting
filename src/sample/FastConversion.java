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
    int N = 8;

    public ArrayList<Double> getFunction(){
        ArrayList<Double> array = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            array.add(Math.cos(4 * Math.PI * i / N) + Math.sin(2 * Math.PI * i / N));
            System.out.println(array.get(i));
        }
        return array ;
    }

    public ArrayList<Double> fastWalshTransform(ArrayList<Double> variables, int sign ) {
        if (variables.size() == 1) {
            return variables;
        }

        int n = variables.size();
        System.out.println(n);
        ArrayList<Double> b = new ArrayList<>();
        ArrayList<Double> c = new ArrayList<>();

        for (int i = 0; i < n / 2; i++) {
            System.out.println(i);
            System.out.println(variables.get(i));
            b.add(i, (variables.get(i) + variables.get(i + n / 2)));
            c.add(i, (variables.get(i) - variables.get(i + n / 2)));

            sumCount ++;
        }

        ArrayList<Double> left = fastWalshTransform(b, sign);
        ArrayList<Double> right = fastWalshTransform(c, sign);
        ArrayList<Double> result = new ArrayList<>();

        if(sign > 0) {
            for(int i = 0; i < n / 2; i++) {
                result.add(i, (left.get(i) / 2));
                result.add((i + n / 2), (right.get(i) / 2));
            }
        }
        else {
            for(int i = 0; i < n / 2; i++) {
                result.add(i, left.get(i));
                result.add(i + n / 2, right.get(i));
            }
        }
        return result;
    }

    public ArrayList<Double> getAbsolute(ArrayList<Complex> fftResult){
        ArrayList<Double> absolute = new ArrayList<>();
        for(int i = 0; i<fftResult.size(); i++){
            absolute.add(fftResult.get(i).abs() / N);
        }
        return absolute;
    }

    int getSumCount(){
        return sumCount;
    }

    int getMulCount(){
        return  mulCount;
    }
}
