import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ScorpionOrange on 2016/11/28.
 */
public class DoubleLinList implements List {
    private DNode head;    // 头指针
    private DNode current;    // 当前节点位置
    private int size;    // 数据元素个数

    public DoubleLinList(){
        // 初始化链表时头指针和当前节点都指向头结点
        head = current = new DNode(null);
        head.setNext(head);
        size = 0;
    }

    public void index(int i) throws Exception{
        if(i < 0 || i > size - 1){
            throw new Exception("参数错误！");
        }
        if(i < (size >> 2)){
            current = head.getNext();
            for(int num = 0; num < i; num++){
                current = current.getNext();
            }
        }
        else {
            for(int num = size - 1; num > i; num--){
                current = current.getPrior();
            }
        }
    }

    /**
     * 新增数据
     * @param object
     * @return
     */
    public boolean add(Object object){
        DNode node = new DNode(object);
        if(current.getPrior() == null){
            head = current;
            node.setPrior(current);
            current.setNext(node);
            current = node;
            head.setPrior(node);
        }
        else {
            node.setPrior(current);
            current.setNext(node);
            current = node;
        }
        size++;
        return true;
    }

    public void insert(int i, Object object) throws Exception{
        if(i < 0 || i > size - 1){
            throw new Exception("参数错误！");
        }
        // 添加一个变量记录current地址
        DNode t = new DNode();
        t.setElement(current.getElement());
        t.setNext(current.getNext());
        t.setPrior(current.getPrior());
        current.getPrior().setNext(t);
        index(i);
        DNode node = new DNode(object);
        node.setPrior(current.getPrior());
        current.getPrior().setPrior(node);
        node.setNext(current);
        current.setPrior(node);
        // 新增后把current地址还原
        current = t;
        size++;
    }

    public Object delete(int i) throws Exception{
        if(i < 0 || i > size - 1){
            throw new Exception("参数错误！");
        }
        index(i);
        Object object = current.getElement();
        current.getPrior().setNext(current.getNext());
        current.getNext().setPrior(current.getPrior());
        size--;
        return object;
    }

    public Object getData(int i) throws Exception{
        if(i < 0 || i > size - 1){
            throw new Exception("参数错误！");
        }
        // 修改，添加一个变量记录current地址
        DNode t = new DNode();
    }



    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public boolean addAll(int index, Collection c) {
        return false;
    }

    public void clear() {

    }

    public Object get(int index) {
        return null;
    }

    public Object set(int index, Object element) {
        return null;
    }

    public void add(int index, Object element) {

    }

    public Object remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator listIterator() {
        return null;
    }

    public ListIterator listIterator(int index) {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
