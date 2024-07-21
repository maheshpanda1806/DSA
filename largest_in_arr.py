def largest(list):
    prevans = -1
    ans = list[0]

    for i in list:
        if i>ans:
            prevans = ans
            ans = i
        elif(i>prevans and i!=ans):
            prevans =i

    return prevans,ans

def even(list):
    return [x for x in list if x%2==0]


def odd(list):
    return [x for x in list if x%2!=0]

my_list = [2,4,5,6,8]
print((largest(my_list)))
print(even(my_list))
print(odd(my_list))


