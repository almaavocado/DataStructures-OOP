public class NodeChar{
    char data;
    NodeChar next;

    public NodeChar(char letter){
        data = letter;
    }

    public String toString(){
        String result = Character.toString(data);
        return result;
    }
}


