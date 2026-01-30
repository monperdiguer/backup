package estdatos;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class MultiMap<K, V> extends AbstractMap<K, V> {
	private SortedMap<K, SortedSet<V>> data;	// diccionario de pares
												// clave/conjunto_de_valores_asociados
	private Set<Map.Entry<K, V>> entrySet;		// vista del multidiccionario como un
												// conjunto de pares clave/valor

	/**
	 * Crea un multidiccionario vacío. La comparación de las claves
	 * se realiza según el orden natural de éstas.
	 */
	public MultiMap() {
		entrySet = new EntrySet(); //vista unica
		this.data = null;
	}
		
	/**
	 * Crea un multidiccionario vacío. Las comparaciones entre
	 * claves se llevan a cabo mediante el comparador especificado.
	 * @param cmp el comparador de las claves del multidiccionario
	 */
	public MultiMap(Comparator<? super K> cmp) {
		this.entrySet = new EntrySet();
		this.data = new TreeMap<K, SortedSet<V>>(cmp);
	}

	/**
	 * Crea un multidiccionario copia del diccionario especificado.
	 * @param m el diccionario a copiar
	 */
	public MultiMap(Map<K, V> m) {
		this();
		for(Map.Entry<K, V> e : m.entrySet()) {
			put(e.getKey(), e.getValue()); //como el addAll()
		}
			
	}
	
	/**
	 * Crea un multidiccionario copia del diccionario especificado.
	 * @param m el diccionario a copiar
	 */
	public MultiMap(SortedMap<K, V> m) {
		this(m.comparator());
		for(Map.Entry<K, V> e : m.entrySet()) {
			put(e.getKey(), e.getValue());
		}
			
	}

	/**
	 * Retorna la vista del multidiccionario como un conjunto
	 * de pares clave/valor.
	 * @return la vista del multidiccionario como un conjunto
	 * de pares clave/valor
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		return entrySet;
	}
	
	/**
	 * Retorna la vista del multidiccionario como un conjunto
	 * de pares clave/valores_asociados, de forma que todos los
	 * valores asociados a una misma clave están contenidos en
	 * un conjunto ordenado.
	 * @return la vista del multidiccionario como un conjunto
	 * de pares clave/conjunto_de_valores_asociados
	 */
	public Set<Map.Entry<K, SortedSet<V>>> entryKeySet() {
		return data.entrySet();
	}
	
	/**
	 * Añade la clave y valor especificados al multidiccionario. Si este ya
	 * contiene el par {@code key/value} retorna el valor especificado, en
	 * caso contrario retorna {@code null}
	 * @param key la clave dada
	 * @param value el valor dado
	 * @return {@code null} si el multidiccionario no contiene el par {@code key/value}
	 * y {@code value} en caso contrario
	 */
	@Override
	public V put(K key, V value) {
		
		//Se obtiene el conjunto de valores asociado a la clave
		SortedSet<V> values = data.get(key);
		
		//Si el conjunto no existe, se crea el conjunto y se inserta la clave
		if(values == null) {
			values = new TreeSet<V>(); //TreeSet: valores ordenados
			data.put(key, values);
		}
		
		//Insercion efectiva del nuevo valor
		if(values.contains(value)) {
			return value;
		}
		
		//Insercion efectiva del nuevo valor
		values.add(value);
		return null;
		
	}
	
	/**
	 * Quita del multidiccionario la clave y valor especificados. Si esta asociación
	 * no se encuentra retorna {@code false} y {@code true} en caso contrario.
	 * @param key la clave dada
	 * @para value el valor dado
	 * @return {@code true} si el par {@code key/value} se encuentra en el diccionario
	 * y {code false} en caso contrario
	 */
	@Override
	public boolean remove(Object key, Object value) {
		
		//Se obtiene el conjunto asociado a la clave
		SortedSet<V> values = data.get(key);
		
		if(values == null) {
			return false;
		}
		
		//Se intenta eliminar el valor
		boolean removed = values.remove(value);
		if(!removed) {
			return false;
		}
		
		//Si el conjunto queda vacio, se elimina la clave
		if(values.isEmpty()) {
			data.remove(key);
		}
		
		return true;
		
	}
	
	/**
	 * Retorna la representación del multidiccionario como una cadena
	 * de caracteres, en la forma:
	 * <pre>
	 * clave1: conjunto de valores asociados a clave1
	 * clave2: conjunto de valores asociados a clave2
	 * ...
	 * </pre>
	 * @return la representación del multidiccionario como una cadena
	 * de caracteres
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Map.Entry<K, SortedSet<V>> e : data.entrySet()) {
			sb.append(e.getKey())
			  .append(": ")
			  .append(e.getValue())
			  .append("\n");
		}
		
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MultiMap<?, ?>)) {
			return false;
		}
		MultiMap<K,V> other = (MultiMap<K, V>) obj;
		if (data == null) {
			return (other.data == null);
		}
		
		return data.equals(other.data);
	}
	
	/**
	 * Una instancia de esta clase es una vista del multidiccionario
	 * como un conjunto de pares clave/valor (K/V)
	 */
	private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {

		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new EntrySetIterator();
		}

		//Numero total de pares (K, V), no de claves 
		@Override
		public int size(){
			
			int total = 0;
			for(SortedSet<V> s : data.values()) {
				total += s.size();
			}
			
			return total;
		}

		//Añade un par (K, V) usando put()
		@Override
		public boolean add(Map.Entry<K, V> e) {
			K k = e.getKey();
			V v = e.getValue();
			SortedSet<V> values = data.get(k);
			boolean existed = (values != null && values.contains(v));
			
			put(k, v);
			return !existed;
		}
		
		/**
		 * Una instancia de esta clase es un iterador de la vista del
		 * multidiccionario como un conjunto de pares clave/valor
		 */
		private class EntrySetIterator implements Iterator<Map.Entry<K, V>> {
			private Iterator<Map.Entry<K, SortedSet<V>>> itrMap;  // iterador sobre el diccionario data
																  // (de su vista como un conjunto de
																  // pares clave/valores_asociados)
			private Iterator<V> itrSet;							  // iterador del conjunto de valores
																  // asociados a una misma clave
			private Map.Entry<K, SortedSet<V>> currentKeySet;	  // par clave/valores_asociados en curso
			private boolean opNext;								  // indica si se ha realizado la operación
																  // next()
			
			private void searchNextKey() {
				// siguiente par clave/valores_asociados
				boolean found = false;
				while (!found && itrMap.hasNext()) { // ignorar claves sin valores asociados
					currentKeySet = itrMap.next();
					itrSet = currentKeySet.getValue().iterator();
					found = itrSet.hasNext();
				}
			}
			
			private EntrySetIterator() {
				opNext = false;
				itrMap = entryKeySet().iterator();
				searchNextKey();
			}

			@Override
			public boolean hasNext() {
				return itrMap.hasNext() || itrSet.hasNext();
			}

			@Override
			public Entry<K, V> next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				
				if (!itrSet.hasNext()) {
					searchNextKey();
				}
				
				opNext = true;				
				return new SimpleEntry<>(currentKeySet.getKey(),
										 itrSet.next());
			}

			//Elimina el ultimo par devuelto por next()
			@Override
			public void remove() {
				if (!opNext) {
					throw new IllegalStateException();
				}
				
				opNext = false;
				itrSet.remove();
			}	
		}
	}
	
}
