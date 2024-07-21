def recur_fibo(a):
    if a<0:
        return 0
    elif a==0 or a==1:
        return a
    else:
        return recur_fibo(a-1) + recur_fibo(a-2)

def fact(num):
    for i in range (1,num):
        num = num*i
    return num

def fact_recur(num):
    if num<=0:
        return 1
    else:
        return num*fact_recur(num-1)


num = int(input("Enter A num"))
print(fact_recur(num))