def print1(n):#print the numvers from 1 to n
    if(n==0):
        return
    
    print1(n-1)
    print(n)

print1(5)
