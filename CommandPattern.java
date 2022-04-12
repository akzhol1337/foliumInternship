import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class DB {
    private List<Data> DBvalues = new ArrayList<>();
    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        DBvalues = command.execute(DBvalues);
        history.push(command);
    }

    public void printData() {
        for(Data data : DBvalues) {
            System.out.print(data.getContent() + " ");
        }
        System.out.println();
    }

    public void undo() {
        Command lastCommand = history.pop();
        DBvalues = lastCommand.undo(DBvalues);
    }
}

class Data {
    private String content;
    Data(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

interface Command {
    List<Data> execute(List<Data> DBvalues);
    List<Data> undo(List<Data> DBvalues);
}

class AddToDBCommand implements Command {
    private Data data;
    
    AddToDBCommand(Data data) {
        this.data = data;
    }

    public List<Data> execute(List<Data> DBvalues) {
        DBvalues.add(data);
        return DBvalues;
    }

    public List<Data> undo(List<Data> DBvalues) {
        DBvalues.remove(data);
        return DBvalues;
    }
}

class RemoveFromDBCommand implements Command {
    private Data data;
    
    RemoveFromDBCommand(Data data) {
        this.data = data;
    }

    public List<Data> execute(List<Data> DBvalues) {
        DBvalues.remove(data);
        return DBvalues;
    }

    public List<Data> undo(List<Data> DBvalues) {
        DBvalues.add(data);
        return DBvalues;
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        DB db = new DB();

        db.executeCommand(new AddToDBCommand(new Data("Akzhol")));
        db.executeCommand(new AddToDBCommand(new Data("Is")));
        db.executeCommand(new AddToDBCommand(new Data("The")));

        Data bestData = new Data("Best");
        Command bestCommand = new AddToDBCommand(bestData);

        db.executeCommand(bestCommand);

        db.printData();

        db.undo();

        db.printData();

        db.executeCommand(bestCommand);

        db.printData();

        db.executeCommand(new RemoveFromDBCommand(bestData));

        db.printData();
        
    }
}