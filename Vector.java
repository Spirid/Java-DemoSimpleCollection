
package lab2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Vector extends Matrix 
{
    
    public Vector(int size)
    {
        super(1, size);        
    }

    
    public void read(int row, String Filename)
    {
        final int SIZE_BUFFRE = 11;
        int n = 0, m = 0;
        int i = -1, j = 0;
        char[] buffer = new char[1];
        
        try
        {
            buffer = new char[11];
        }
        catch (OutOfMemoryError e)
        {
            System.out.println("Out of memory exception (buffer)!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }
        
        Matrix tmp = new Matrix(1, row);
        
        char str = '0';
        try (FileInputStream myInput = new FileInputStream(Filename)) 
        {
            
                i = myInput.read();
                while (i != -1)
                {
                    str = (char)i;                                    
                    
                    if ((str >= '0' && str <= '9') || str == '+' || str == '-')
                    {
                      for (char el : buffer) 
                      {
                          el = ' ';
                      }
                    j = 0;
                        while ((str >= '0' && str <= '9') || str == '+' || str == '-')
                      {
                          buffer[j] = str;
                          ++j;
                          i = myInput.read();
                          str = (char)i;
                          if (j == SIZE_BUFFRE || i == -1) {break;}
                      }
                      
                      try 
                      {
                          String s = new String(buffer, 0, j);
                          tmp.matrix[m][n] = Integer.parseInt(s);
                          ++m;
                          if (m == tmp.matrix.length) 
                          {
                              m = 0;
                              ++n;
                          }
                          if (n == tmp.matrix[0].length)
                          {
                              matrix = tmp.matrix;
                              return;
                          }
                          
                      } 
                      catch(NumberFormatException s)
                      {
                          System.out.println("In string \"" + s.getLocalizedMessage() + "\" not a number!");
                          System.exit(1);
                      }
                    }
                    i = myInput.read();
                }
            
            System.out.println("The result: " + str);
        }
        
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }
        
        catch (IOException e)
        {
            System.out.println("IO error!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
        }

	catch (NumberFormatException e) 
	{
            System.out.println("Wrong number!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
	}
        
	catch (ArrayIndexOutOfBoundsException e) 
	{
            System.out.println("Wrong matrix size!");
            System.out.println(e.getClass());
            System.out.println(e.getClass().getSuperclass());
            System.out.println(e.getClass().getSuperclass().getSuperclass());
            System.out.println();
	}

    }
    
    
    public double length() 
    {
	double el=0.0;
	for(int i=0 ; i < row ; ++i)
        {
		el+=Math.pow(matrix[0][i], 2);
        } 
	return Math.sqrt(el);
    }
    
}
