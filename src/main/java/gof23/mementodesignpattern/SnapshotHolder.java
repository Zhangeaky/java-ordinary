package gof23.mementodesignpattern;

import java.util.Stack;

public class SnapshotHolder {

    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputText inputText) {

        snapshots.push(inputText);

    }

}
