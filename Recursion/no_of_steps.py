def no_of_steps(n):
    if n==0:
        return 0
    if n%2==0:
        return no_of_steps(int(n/2))+1
    else:
        return no_of_steps(n-1)+1


def no_of_steps(n,count):
    if n==0:
        return count
    if n%2==0:
        return no_of_steps(int(n/2),count+1)
    else:
        return no_of_steps(n-1,count+1)
    

print(no_of_steps(14,0))

