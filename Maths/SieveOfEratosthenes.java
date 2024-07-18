public class SieveOfEratosthenes {
    // A function to find prime numbers up to n using the Sieve of Eratosthenes algorithm
    static void Primes(int n, boolean[] primes) {
        // Loop through numbers from 2 to the square root of n
        for (int i = 2; i * i <= n; i++) {
            // If i is marked as prime (false), mark its multiples as non-prime (true)
            if (!primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }
        // Loop through the boolean array and print the prime numbers
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n + 1]; // Initialize a boolean array to mark prime numbers
        Primes(n, primes); // Call the Primes function to find and print prime numbers up to n
    }
}
