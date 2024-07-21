def rev(n,size):
    if n==0:
        return 0
    return n%10*10**(size-1) + rev(int(n/10),size-1)

def main():
    print(rev(1734,4))

main()