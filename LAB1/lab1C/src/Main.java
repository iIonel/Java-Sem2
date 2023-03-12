public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        System.out.println(n);
        int binary = 10101;
        int finalDecimalForBinary = 0;
        int power = 0;
        while(binary > 0){
            int rest = binary%10;
            finalDecimalForBinary += rest*Math.pow(2,power);
            binary /= 10;
            power++;
        }

        n += finalDecimalForBinary;
        System.out.println(finalDecimalForBinary);

        int base = 1;
        int finalDecimalForHex = 0;
        for(int i = 2; i > 0; --i){
            finalDecimalForHex = finalDecimalForHex + (int)(('F')-55) * base;
            base *=16;
        }
        System.out.println(finalDecimalForHex);
        n += finalDecimalForHex;
        n*=6;
        System.out.println(n);
        while(n > 9){
            int s = 0;
            int nClone = n;
            while(nClone > 0){
                s += nClone % 10;
                nClone /= 10;
            }
            n = s;
        }
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

    }
}