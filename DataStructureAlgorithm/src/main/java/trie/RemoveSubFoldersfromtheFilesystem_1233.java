package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoveSubFoldersfromtheFilesystem_1233 {
    class TrieNode {
        public boolean end = false;
        public HashMap<String, TrieNode> children = new HashMap<>();
    }

    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for(String f : folder){
            insertFolder(root, f);
        }
        List<String> result = new ArrayList<String>();
        for (String f: folder){
            if(!removeSubfolders(root, f)){
                result.add(f);
            }
        }
        return result;
    }

    private void insertFolder(TrieNode root, String folder){
        insertFolder(root, 1, folder.split("/"));
    }

    private void insertFolder(TrieNode root, int curIndex, String[] folder){
        String subFolder = folder[curIndex];
        TrieNode children = root.children.get(subFolder);
        if(children == null){
            children = new TrieNode();
            root.children.put(subFolder, children);
        }
        if(curIndex == folder.length - 1){
            children.end = true;
            return;
        }
        insertFolder(children, curIndex + 1, folder);
    }

    private boolean removeSubfolders(TrieNode root, String folder){
        return removeSubfolders(root, 1, folder.split("/"));
    }

    private boolean removeSubfolders(TrieNode root, int curIndex, String[] folder){
        String subFolder = folder[curIndex];
        TrieNode children = root.children.get(subFolder);
        if(children == null){
            return false;
        }
        if(children.end){
            return curIndex != folder.length - 1;
        }
        if(curIndex == folder.length - 1){
            return false;
        }
        return removeSubfolders(children, curIndex + 1, folder);
    }

    public static void main(String[] args) {
        RemoveSubFoldersfromtheFilesystem_1233 r = new RemoveSubFoldersfromtheFilesystem_1233();
        System.out.println(r.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }
}
