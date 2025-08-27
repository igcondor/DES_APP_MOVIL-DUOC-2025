package com.example.proyectobase.utils

object OPMatematicas {

    /*
    * funcion sumar recibe 2 parametros
    * retorna un numero entero numerico
    */
    fun sumar(n1:Int,n2:Int):Int{
        return n1+n2
    }

    fun restar(n1:Int,n2:Int):Int{
        return n1-n2
    }
    fun multiplicar(n1:Int,n2:Int):Int{
        return n1*n2
    }
    fun dividir(n1:Int,n2:Int):Int{
        try{
        return n1/n2}
        catch (e: ArithmeticException){
            return 0}
        finally {
            println("SE A PRODUCIDO UN ERROR ARITMETICO")
        }
        }
    }
