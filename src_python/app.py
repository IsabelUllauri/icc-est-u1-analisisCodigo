from benchmarking import Benchmarking
from metodos_ordenamiento import MetodosOrdenamiento

if __name__ == "__main__":
    print("funciona")
   
    #instancias
    metodos_ordenamiento=MetodosOrdenamiento()
    benchmark=Benchmarking()

    tamanio=10000
    arreglo_base=benchmark.build_arreglo(tamanio)

    metodos={"Burbuja": metodos_ordenamiento.sortByBubble, #funcion sin ejecutar
             "Seleccion": metodos_ordenamiento.sortBySelecction}
    resultado=[]
    for nombre, metodo in metodos.items():
        tiempo= benchmark.medir_tiempo(metodo, arreglo_base)
        #se ejecuta por primera vez burbuja y ejecuta con el arreglo
        #se ejecuta la segunda sellecion se ejecuta con el arreglo
        tuplaResultado=(tamanio, nombre, tiempo)# devuelve el tamanio del arreglo, nombre del metodo, y tiempomedido
        resultado.append(tuplaResultado)
    
    for resultados in resultado:
        tamanio, nombre, tiempo= resultados
        print(f" Tamano: {tamanio}, Metodo: {nombre}, tiempo: {tiempo:.6f}segundos")

