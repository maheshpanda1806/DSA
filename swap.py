def swap1(a,b):
    c = a
    a = b
    b = c
    print(f"{a} and {b}")

def swap2(a,b):
    a = a+b
    b = a - b
    a = a - b
    return a,b

a = float(input("Enter 1st Number"))
b = float(input("Enter of 2nd number"))
print(swap2(5,6))