

class MetodosOrdenamiento:
    def sortByBubble(self, arreglo):
        arreglo= arreglo.copy()
        n = len(arreglo)
        for i in range(n):
            for j in range(i+1, n):
                if arreglo[i]>arreglo[j]:
                    #x=arreglo[i]
                    #arreglo[i]=arreglo[j]
                    #arreglo[j]=x
                    arreglo[i], arreglo[j]= arreglo[j], arreglo[i]
        return arreglo     

    def sortBySelecction (self, arreglo):
        arreglo=arreglo.copy()
        n=len(arreglo)
        for i in range (n):
            aux= i
            for x in range (i+1,n):
                if arreglo[x]<arreglo[aux]:
                    m= arreglo[aux]
                    arreglo[aux]=arreglo[i]
                    arreglo[i]=m
            return arreglo










        