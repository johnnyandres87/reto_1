package com.unab.main;

import java.util.*;

/**
 *
 * @author Johnny Antia <Johnny.Antia at jantia.com>
 */
public class Principal
{

    static boolean validaDocumento(double documento)
    {
        return documento != 0;
    }

    public static void main(String[] args)
    {
        Scanner datos = new Scanner(System.in).useLocale(Locale.ROOT);
        Map<Integer, String> resultadosNotas = new HashMap<>();
        Integer documentoEstudiante = -1;
        Integer cantidadEstudiantes;
        double nota = 0.0;
        String estado;

        while (validaDocumento(documentoEstudiante))
        {
            try
            {
                System.out.print("ingrese por favor el documento del estudiante:");
                documentoEstudiante = datos.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Los valores no son validos rectifique y pruebe nuevamente.."
                        + "\n El programa se cerrara automaticamente......");
                System.exit(0);
            }

            if (validaDocumento(documentoEstudiante))
            {
                try
                {
                    System.out.println("Ingrese por favor la nota definitiva del estudiante");
                    nota = datos.nextDouble();
                }
                catch (Exception e)
                {
                    System.out.println("Los valores no son validos rectifique y pruebe nuevamente.."
                            + "\n El programa se cerrara automaticamente......");
                    System.exit(0);
                }

                if (nota >= 3 && nota <= 5)
                {
                    estado = "Aprobó la materia";
                    resultadosNotas.put(documentoEstudiante, estado);

                }
                else if (nota >= 2 && nota < 3)
                {
                    estado = "Debe Habilitar la materia";
                    resultadosNotas.put(documentoEstudiante, estado);

                }
                else if (nota > 0 && nota < 2)
                {
                    estado = "Perdio la materia";
                    resultadosNotas.put(documentoEstudiante, estado);

                }

                else
                {
                    System.out.println("Debe ingresar notas entre 0.0 - 5.0");
                }

            }

            else if (validaDocumento(documentoEstudiante))
            {

                resultadosNotas.forEach((miLLave, miValor) ->
                {
                    System.out.println(miLLave + "'" + miValor + "'");
                });

                System.out.println("El programa se finalizara...");
                System.exit(0);
            }

        }

        resultadosNotas.forEach((miLLave, miValor) ->
        {
            System.out.println(miLLave + "'" + miValor + "'");
        });

        System.out.println("El programa se finalizara...");
        System.exit(0);

    }
}
