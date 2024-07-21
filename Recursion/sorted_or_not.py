def check(i,list):
    if len(list)==i:
        return True
    if list[i-1]<=list[i]:
        return check(i+1,list)
    else:
        return False

list= [1,2,3,8,5]
print(check(1,list))