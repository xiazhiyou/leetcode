package as;

import java.util.TreeMap;

import as.TrieNode2.TrieNode;

public class TrieNode2 {

		public static class TrieNode {
			public int path;
			public int end;
			public TrieNode[] map;
			public int value;
	
			public TrieNode() {
				path = 0;
				end = 0;
				map = new TrieNode[26];
				value=0;
			}
			public TrieNode(int value) {
				this.value=value;
		    }
		}
	       
			public static class Trie {
				private TrieNode root;

				public Trie() {
					root = new TrieNode();
				}
				public  void insert(String word, int val) {
			       if(!search(word)){
			    	   if (word == null)
				            return;
		
				        char[] chs = word.toCharArray();
				        TrieNode node = root;
				        int index = 0;
				        for (int i = 0; i < chs.length; i++) {
				            index = chs[i] - 'a';
				            if (node.map[index] == null) {
				            	node.map[index] = new TrieNode();
				            	node.map[index].value=0;
				            }
				            node.map[index].value = node.map[index].value+val;
				            
				            node = node.map[index];
				            node.path++;
				        }
				        node.end++;
			       }else{
			    	   if (word == null)
				            return;
		
				        char[] chs = word.toCharArray();
				        TrieNode node = root;
				        int index = 0;
				        for (int i = 0; i < chs.length; i++) {
				            index = chs[i] - 'a';
				            node.map[index].value=val;
				            
				            node = node.map[index];
				            node.path++;
				        }
				        node.end++;
			       }
			    }
				public boolean search(String word) {
					if (word == null) {
						return false;
					}
					char[] chs = word.toCharArray();
					TrieNode node = root;
					int index = 0;
					for (int i = 0; i < chs.length; i++) {
						index = chs[i] - 'a';
						if (node.map[index] == null) {
							return false;
						}
						node = node.map[index];
					}
					return node.end != 0;
				}
				
		    public  int sum(String pre) {
		        if (pre == null) 
		            return 0;

		        char[] chs = pre.toCharArray();
		        TrieNode node = root;
		        int index = 0;
		        for (int i = 0; i < chs.length; i++) {
		            index = chs[i] - 'a';
		            if (node.map[index] == null) {
		                return 0;
		            }
		            node = node.map[index];
		        }
		        return node.value;
		    }
		}
		
		
	   	    
	    public static void main(String[] args) {
			Trie node = new Trie();
			node.insert("aa", 3);
			node.insert("aa", 2);
			System.out.println(node.sum("a"));
		}
	}

