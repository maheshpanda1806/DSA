def box(n,m):
    for i in range(n):
         for j in range(m):
          print("*",end="")
         print("")

def box2(n,m):
   for i in range(n):
      print("*"*m)


def right_angled_triangle(n):
   for i in range(n):
       for j in range(i):
          print("*",end ="")
       print(" ")


def right_angled_triangle_inverted(n):
   for i in range(n):
       for j in range(n-i):
          print("*",end ="")
       print(" ")



def right_angled_triangle2(n):
   for i in range(n+1):
      print("*"*i)
      
    


def right_angled_triangle_inverted2(n):
   for i in range(n):
       print("*"*(n-i))
       
