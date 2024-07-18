#include <stdio.h>
#include <math.h>

int factorial(int n){
    if(n==0){
        return 1;
    }
    return n*factorial(n-1);
}

int cube(int n){
    return pow(n,3);
}

double logsquare(int n){
    return pow(log2((double)n),2);
}

double lognlong(int n){
    return pow(log2((double)n),log2((double)n));
}

int ntwon(int n){
    return n*pow(2,n);
}

double nlogn(int n){
    return n*log2((double)n);
}

double lnn(int n){
    return log((double)n);
}

double sqrttwologn(int n){
    return pow(sqrt(2.0),log2((double)n));
}

double sqrtlogn(int n){
    return sqrt(log2((double)n));
}

double lognfact(int n){
    return log2((double)factorial(n));
}

double n1logn(int n){
    return pow(n,1/log2((double)n));
}

void main(){
    //cube
  for (int i = 1; i <= 100; i++){
  printf("The cube is %d is %d\n",i,cube(i));
  }
    //lognsquare
    for (int i = 1; i <= 100; i++){
  printf("The logsquare is %d is  %lf \n",i,logsquare(i));
  }
   
      //lognlogn
    for (int i = 1; i <= 100; i++){
    printf("The lognlogn is %d is %lf\n",i,lognlong(i));
    }
   
    //ntwon
    for (int i = 1; i <= 100; i++){
    printf("The ntwon is %d is %d\n",i,ntwon(i));
    }
   
    //nlogn
    for (int i = 1; i <= 100; i++){
    printf("The nlogn is %d is %lf\n",i,nlogn(i));
    }
   
    //lnn
    for (int i = 1; i <= 100; i++){
    printf("The lnn is %d is %lf\n",i,lnn(i));
    }
   
     //sqrttwologn
    for (int i = 1; i <= 100; i++){
    printf("The sqrttwologn is %d is %lf\n",i,sqrttwologn(i));
    }
    //sqrtlogn
    for (int i = 1; i <= 100; i++){
    printf("The sqrtlogn is %d is %lf\n",i,sqrtlogn(i));
    }
   
    //lognfact
    for (int i = 1; i <= 100; i++){
    printf("The lognfact is %d is %lf\n",i,lognfact(i));
    }
   
   
   //n1logn
    for (int i = 1; i <= 100; i++){
    printf("The cube is %d is %lf\n",i,n1logn(i));
    }
}