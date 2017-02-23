
package lab2;

public class Lab2 
{

    public static void main(String[] args) 
    {
        System.out.println("Lab2.Ex1");
        Matrix matrix = new Matrix(2,2);

        matrix.output();
                
	matrix.write("data.txt");
		
	Matrix fromFile = new Matrix(2,2);
	fromFile.read(2,2,"data.txt");
	System.out.println("Matrix,readed:");
	fromFile.output();
		
	System.out.println("Recorded and read matrix are equa: "+matrix.equal(fromFile));
		
	System.out.println("Anoser matrix");
	Matrix other = new Matrix(3,4);

	System.out.println("This matrix is not equal to the firs:");
	other.output();
	System.out.println("Whether the matrix is? -"+matrix.equal(other));
		
	System.out.println("Other size matrix:");
	Matrix otherSize = new Matrix(5, 2);
		
	System.out.println("Sum of the matrix is the same size:");
	Matrix summ;
	try 
	{
            summ = matrix.add(other);
	} 
        catch(SizeMatrixError e) 
	{
            System.out.println(e);
            summ = new Matrix(0,0);
	}
	summ.output();
		
	System.out.println("Sum of the matrix of different sizes:");
	Matrix summ2;
	try 
	{
            summ2 = matrix.add(otherSize);
	}
        catch(SizeMatrixError e) 
	{
            System.out.println(e);
            summ2 = new Matrix(0,0);
	}
            summ2.output();
	
        //Vector    
            
	Vector v = new Vector(5);
	System.out.println("Input the vector:");

	System.out.println("Output of vector:");
	v.output();
	System.out.println("Length of vector"+v.length());
	v.write("vector.txt");
	Vector v2 = new Vector(4);
        v2.read(3,"vector.txt");
	System.out.println("Vector after read:");
	v2.output();
	
        //End Vector

        
        System.out.println("Lab1.Ex1.end");
        System.out.println();
        
        System.exit(0);
    }
    
}
