package eg.edu.alexu.csd.datastructure.mailserver.models.folder;

import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.ILinkedList;

public interface IFolder {
    String getName();

    void setName(String name);

    ILinkedList getFiles();

    void setFiles(ILinkedList files);

    String getPathName();

    void setPathName(String pathName);
}
