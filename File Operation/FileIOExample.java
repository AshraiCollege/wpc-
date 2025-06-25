import java.io.*;
class x{
public static void main(String args[]){
try{
FileWriter f=new FileWriter("abc.txt");
f.write("hello this is a test file\nIt has two lines");
f.close();
BufferedReader br=new BufferedReader(new FileReader("abc.txt"));
String s;
while((s=br.readLine())!=null){
System.out.println(s);
}
br.close();
}
catch(Exception e){}
}
}

