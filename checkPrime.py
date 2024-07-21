def is_prime(num):
    for i in range(2,num//2 +1):
        if(num%i==0):
            return False
    return True


# set_my = {1,2,3,3,4}
# print(set_my)
my_prime_list = [x for x in range(2,100)if is_prime(x)]
print((my_prime_list))
    