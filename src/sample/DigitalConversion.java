package sample;

import java.util.ArrayList;

/**
 * Created by Oxana on 22.02.2016.
 */
public class DigitalConversion {

    int sumCount = 0;
    int mulCount = 0;
    int N = 8;

    ArrayList<Double> getFunctionValues(){
        ArrayList<Double> functionValues = new ArrayList<>();
        for(int i = 0; i<N; i++){
            functionValues.add(Math.cos(2*Math.PI*i/N)+Math.sin(2*Math.PI*i/N));
        }
        return functionValues;
    }

    int getWalshFunctionValue(int n, int t){
        int walshFunctionValue = 1;
        ArrayList<Integer> binaryN = getBinaryNumber(n);
     //   System.out.println(binaryN.size());
        for(int k = 1; k < binaryN.size(); k++) {
            System.out.println(getRademaherFunction(k, t));
            walshFunctionValue *= Math.pow(getRademaherFunction(k, t), binaryN.get(binaryN.size() - k + 1 - 1) ^ binaryN.get(binaryN.size() - k - 1));
        }

        return  walshFunctionValue;
    }

    ArrayList<Integer> getWalshValues() {
        ArrayList<Integer> walshValues = new ArrayList<>();
            for(int i = 2; i <= N + 1; i++) {
                walshValues.add(i - 1, getWalshFunctionValue(7, 1 / i)); //???????????????????????/
               // System.out.println(walshValues.get(i - 1));
            }
        return walshValues;
    }


    int getRademaherFunction(int k, int t){
        if(Math.sin(Math.pow(2, k)*Math.PI*t) > 0){
            return 1;
        }
        return -1;

    }

    ArrayList<Integer> getBinaryNumber(int number){
        ArrayList<Integer> binary = new ArrayList<>();
        while(number > 0 ){
            binary.add(number%2);
            number -= 2;
        }
        return binary;
    }

    ArrayList<Double> getCoeff(){
        ArrayList<Double> functionValue = getFunctionValues();
        ArrayList<Double> coeff = new ArrayList<>();
        double sum = 0.0;
        for(int k = 0; k < N; k++){   //N-1
            sum = 0;
            for(int i = 1; i < N; i++){
                sum+=functionValue.get(i)*getWalshFunctionValue(k, 1 / i); //???????????????????????/
            }
            coeff.add(sum);
        }
        return coeff;

    }



//    public double getFunction(int n){
//        return (Math.cos(4*Math.PI*n/16)+Math.sin(2*Math.PI*n/16));
//}
//
//
//    private ArrayList<Complex> getArrayValue(int sign, int division, boolean isReverse){
//        ArrayList<Complex> arrayCoeff = new ArrayList<>();
//        for(int i = 0; i<16; i++){
//            arrayCoeff.add(getSummand(i, sign, division, isReverse));
//        }
//        return arrayCoeff;
//    }
//
//    private Complex getSummand(int index, int sign, int division, boolean isReverse){
//        Complex sum = new Complex(0,0);
//        ArrayList<Complex> directConversion = new ArrayList<Complex>() ;
//        if(isReverse){
//            directConversion = directConversion();
//            for(int i = 0; i<16; i++){
//                sum = sum.plus(directConversion.get(i).times(new Complex(Math.cos(2*Math.PI*i*index/16),sign*Math.sin(2*Math.PI*i*index/16))));
//                sumCount++;
//                mulCount++;
//            }
//        }
//        else{
//            for(int i = 0; i<16; i++){
//                sum = sum.plus(new Complex(Math.cos(2*Math.PI*i*index/16),sign*Math.sin(2*Math.PI*i*index/16) ).times(getFunction(i)));
//                sumCount++;
//                mulCount++;
//            }
//        }
//        Complex coeff = sum.divides(new Complex(division,0));
//        return coeff;
//
//    }
//
//    public ArrayList<Complex> directConversion(){
//
//        return getArrayValue(1, 16,false);
//    }
//    public ArrayList<Complex> reverseConversion(){
//        return getArrayValue(-1, 1,true);
//    }
//
//    public ArrayList<Double> getAbsolute(){
//        ArrayList<Double> absoluteArray = new ArrayList<Double>();
//        ArrayList<Complex> complexArray = directConversion();
//        for(int i = 0; i<complexArray.size(); i++){
//            absoluteArray.add(complexArray.get(i).abs());
//        }
//        return absoluteArray;
//    }
//
//    public int getMulCount(){
//        return mulCount;
//    }
//
//    public int getSumCount(){
//        return sumCount;
//    }



}
