def sum():
    my_list= [[1,2,3],[2,3,4],[5,6,7],[2,3,4]]
    not_my_list =[[1,1,1],[2,1,2],[2,3,4],[5,6,7]]
   # ans = [x for x in my_list] 
    ans = [[0 for x in range(len(my_list[0]))] for x in range(len(my_list))]
    print(ans)
    for i in range(len(my_list)): 
        for j in range(len(my_list[0])):
         ans[i][j] = my_list[i][j] + not_my_list[i][j]
    print(ans)
 


def transpose():
    my_list= [[1,2,3],[2,3,4],[5,6,7],[2,3,4]]
    ans = [[0 for x in my_list] for x in my_list[0]]
    print(ans)

    for i in range(len(ans)):
       for j in range(len(ans[0])):
          ans[i][j] = my_list[j][i]
    
    print(ans)

def mmultiply():
    my_list= [[1,2,3],[2,3,4],[5,6,7],[2,3,4]]
    not_my_list =[[1,1,1],[2,1,2],[2,3,4],[5,6,7]]
    
     
    

transpose()


