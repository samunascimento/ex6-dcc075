package com.mycompany.ex6;
import java.math.BigInteger;
import java.security.SecureRandom;
/**
 *
 * @author Samuel
 */
public class Ex6 {
 
    private static final BigInteger ONE = BigInteger.ONE;
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        // Escolhendo um número primo grande p
        BigInteger p = new BigInteger("31");
        // Escolhendo uma raiz primitiva módulo p
        BigInteger g = new BigInteger("3");

        BigInteger a = new BigInteger("8");
        BigInteger b = new BigInteger("27");
        
        // A calcula A = g^a mod p
        BigInteger A = g.modPow(a, p);
        // B calcula B = g^b mod p
        BigInteger B = g.modPow(b, p);

        // A e B trocam os valores
        // A calcula s = B^a mod p
        BigInteger sA = B.modPow(a, p);
        // B calcula s = A^b mod p
        BigInteger sB = A.modPow(b, p);

        
        System.out.println("Valor A: " + A);
        System.out.println("Valor B: " + B);
        
        // Ambos devem obter o mesmo segredo
        System.out.println("Segredo compartilhado por A: " + sA);
        System.out.println("Segredo compartilhado por B: " + sB);
    }

    private static BigInteger generateRandomSecret(BigInteger p) {
        BigInteger secret;
        do {
            secret = new BigInteger(p.bitLength(), random);
        } while (secret.compareTo(ONE) <= 0 || secret.compareTo(p.subtract(ONE)) >= 0);
        return secret;
    }
}
