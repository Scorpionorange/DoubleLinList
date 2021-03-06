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
        t.setElement(current.getElement());
        t.setNext(current.getNext());
        t.setPrior(current.getPrior());
        current.getPrior().setNext(t);
        index(i);
        Object object = current.getElement();
        // 新增后把current地址还原
        current = t;
        return object;
    }

    /**
     * 输出链表数据
     */
    public void output(){
        DNode t = head.getNext();
        for(; t != null; t = t.getNext()){
            System.out.print(t.getElement() + "");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        DoubleLinList dl = new DoubleLinList();

        System.out.println("向双向链表中依次添加11，22，33");
        // 下标从0开始
        // 向双向链表中新增第一个数据
        dl.add(11);
        // 向双向链表中新增第二个数据
        dl.add(22);
        // 向双向链表中新增第三个数据
        dl.add(33);
        dl.output();
        System.out.println("向双向链表中第二个位置插入44");
        dl.insert(1,44);
        dl.output();
        // 输出链表的长度
        System.out.println("输出链表的长度：" + dl.size());
        // 获得下标为2的节点中的数据
        System.out.println("输出下标为2的数据：" + dl.getData(2));
        // 删除下标为1的节点
        dl.delete(1);
        // 输出删除后链表的长度
        System.out.println("删除下标为1的节点后的链表长度：" + dl.size());
        dl.output();
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
