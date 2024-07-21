def fac(n):
    if(n<0):
        return -1
    if(n==1 or n==0):
        return 1
    return n*fac(n-1)

def main():
    n = 5
    print(f"The Factorial of the number {n} is {fac(n)}")

main()
