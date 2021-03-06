package collections;
import java.util.Arrays;

public class ArrayCollection extends AbstractCollection{
	private final int initialLength=1;
	public int size;
	private Object[] data=new Object[initialLength-1];
	public int size() {
		return size;
	}
	public boolean add(Object obj) {
		if(size==data.length) {
			resize();
		}
		data[size++]=obj;
		return true;
	}
	public void resize() {
		Object[] copy=new Object[data.length+1];
		System.arraycopy(data,0,copy,0,this.size);
		this.data=copy;
	}
	public Iterator iterator() {
		return new Iterator() {
			private int i=0;
			private boolean okToRemove=false;
			public boolean hasNext() {
				return (i<size);
			}
			public Object next() {
				if(i==size) {
					throw new RuntimeException();
				}
				okToRemove=true;
				return data[i++];
			}
			public void remove() {
				if(!okToRemove) throw new IllegalStateException();
				data[--i]=data[--size];
				data[size]=null;
				okToRemove=false;
			}
		};
	}
	public static void main(String[] args) {
		ArrayCollection bag=new ArrayCollection();
		bag.add("One");
		bag.add("Two");
		bag.add("Three");
		bag.add("Four");
		bag.add("Five");
		System.out.println(bag);
//		System.out.println(bag.size());
//		Iterator it=bag.iterator();
//		System.out.println(it.next());
//		System.out.println( bag.contains("To"));
//		it.remove();
//		it=bag.iterator();
//		it.next();
//		System.out.println(bag.remove("Three"));
		bag.remove("Five");
//		System.out.println(bag.size());
		System.out.println(bag);
	}
}
