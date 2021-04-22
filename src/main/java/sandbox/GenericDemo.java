package sandbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class GenericDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("aga");
        System.out.println(strings.get(0).toUpperCase(Locale.ROOT));

        Collection<Number> numbers = new ArrayList<>(); // diamond operator

        Collection<Number> numbers_exactly = new ArrayList<Number>();

        ArrayList<? extends Number> numbers_extends = new ArrayList<Integer>();

        getValue(5).intValue();

        GenericDemo.<String>getValue().toUpperCase(Locale.ROOT);
    }


    private static <U> U getValue(U param){
        return null;
    }

    private static <V> V getValue(){
        return null;
    }

}

interface Message<T>{
    T getBody();
    void setBody(T body);
};

class IntMessage1 implements Message {
    @Override
    public Object getBody() {
        return null;
    }

    @Override
    public void setBody(Object body) {

    }
}

//second option
class IntMessage2 implements Message<Integer>{

    @Override
    public Integer getBody() {
        return null;
    }

    @Override
    public void setBody(Integer body) {

    }
}

// third option
class AbstractMessage<T> implements Message<T>{

    @Override
    public T getBody() {
        return null;
    }

    @Override
    public void setBody(T body) {

    }

}

/*
class TypeComparableMessage<T> implements Message{
    public boolean isSameType(Message newMessage){
        return newMessage instanceof T;
    }

}
class IntMessage extends TypeComparableMessage<IntMessage>{
}
*/