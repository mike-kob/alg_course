


public interface MyTree<T> {
    
    boolean isEmpty();
    
    int getSize();
    
    void addValue(T newValue, T fatherValue, boolean isAddingAsLeftSon);
    
    void removeValue(T value);    
}
