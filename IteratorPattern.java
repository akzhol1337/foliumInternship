interface Iterator {
    public boolean hasNext();

    public Object next();
}

interface Collection {
    Iterator getIterator();
}

class Developer implements Collection {
    private String name;
    private String[] techStack;

    Developer(String name, String[] techStack) {
        this.name = name;
        this.techStack = techStack;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTechStack() {
        return this.techStack;
    }

    public void setTechStack(String[] techStack) {
        this.techStack = techStack;
    }

    public Iterator getIterator() {
        return new TechStackIterator();
    }

    private class TechStackIterator implements Iterator{
        int index;

        public boolean hasNext() {
            if(index < techStack.length) {
                return true;
            }
            return false;
        }

        public Object next() {
            return techStack[index++];
        }
    }
}

class IteratorPattern {
    public static void main(String[] args) {
        String[] techStack = {"Java", "Kotlin", "Spring", "Ktor", "PostgreSQL", "MongoDB"};

        Developer developer = new Developer("Akzhol", techStack);

        Iterator iterator = developer.getIterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}