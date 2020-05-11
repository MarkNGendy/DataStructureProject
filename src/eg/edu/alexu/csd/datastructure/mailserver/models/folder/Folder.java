package eg.edu.alexu.csd.datastructure.mailserver.models.folder;

import eg.edu.alexu.csd.datastructure.mailserver.useddatastructures.linkedlists.ILinkedList;

public class Folder implements IFolder{
    private String pathName;
    private String name;
    private ILinkedList files;

    public Folder(String pathName, String name, ILinkedList files) {
        this.pathName = pathName;
        this.name = name;
        this.files = files;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ILinkedList getFiles() {
        return files;
    }

    @Override
    public void setFiles(ILinkedList files) {
        this.files = files;
    }

    @Override
    public String getPathName() {
        return pathName;
    }

    @Override
    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}
