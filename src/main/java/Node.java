public class Main {

    public static void main(String[] args) {
        Node<Integer> l1 = new Node<>(1, new Node<>(3, new Node<>(5)));
        Node<Integer> l2 = new Node<>(2, new Node<>(3, new Node<>(4)));
        printList(mergeSorted(l1, l2));

        Node<Integer> unsorted = new Node<>(5, new Node<>(3, new Node<>(8, new Node<>(1))));
        printList(selectionSort(unsorted));

        Node<Integer> listForDistance = new Node<>(5, new Node<>(8, new Node<>(3, new Node<>(8, new Node<>(2, new Node<>(9))))));
        System.out.println(sumDistances(listForDistance, 8));

        Node<Integer> listForDifferent = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(2))));
        System.out.println(allDifferent(listForDifferent));

        Node<Integer> listForUnique = new Node<>(1, new Node<>(2, new Node<>(2, new Node<>(3, new Node<>(1)))));
        printList(uniqueList(listForUnique));
    }

    public static Node<Integer> mergeSorted(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.getValue() <= l2.getValue()) {
                current.setNext(new Node<>(l1.getValue()));
                l1 = l1.getNext();
            } else {
                current.setNext(new Node<>(l2.getValue()));
                l2 = l2.getNext();
            }
            current = current.getNext();
        }
        while (l1 != null) {
            current.setNext(new Node<>(l1.getValue()));
            l1 = l1.getNext();
            current = current.getNext();
        }
        while (l2 != null) {
            current.setNext(new Node<>(l2.getValue()));
            l2 = l2.getNext();
            current = current.getNext();
        }
        return dummy.getNext();
    }
  //יעילות הפעולה היא o(n) כאשר N הוא אורך הרשימה

    public static Node<Integer> selectionSort(Node<Integer> head) {
        Node<Integer> sortedDummy = new Node<>(0);
        Node<Integer> sortedTail = sortedDummy;
        while (head != null) {
            Node<Integer> minNode = head;
            Node<Integer> minPrev = null;
            Node<Integer> prev = head;
            Node<Integer> curr = head.getNext();
            while (curr != null) {
                if (curr.getValue() < minNode.getValue()) {
                    minNode = curr;
                    minPrev = prev;
                }
                prev = curr;
                curr = curr.getNext();
            }
            if (minPrev != null) minPrev.setNext(minNode.getNext());
            else head = head.getNext();
            minNode.setNext(null);
            sortedTail.setNext(minNode);
            sortedTail = sortedTail.getNext();
        }
        return sortedDummy.getNext();
    }
  //יעילות הפעולה היא o(nבריבוע ) כאשר N הוא אורך הרשימה


    public static int sumDistances(Node<Integer> head, int value) {
        int index = 0, firstIndex = -1, lastIndex = -1;
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == value) {
                if (firstIndex == -1) firstIndex = index;
                lastIndex = index;
            }
            current = current.getNext();
            index++;
        }
        if (firstIndex == -1) return -1;
        return firstIndex + (index - 1 - lastIndex);
    }
//יעילות הפעולה היא o(n) כאשר N הוא אורך הרשימה

    public static boolean allDifferent(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            Node<Integer> runner = current.getNext();
            while (runner != null) {
                if (current.getValue().equals(runner.getValue())) return false;
                runner = runner.getNext();
            }
            current = current.getNext();
        }
        return true;
    }
  //יעילות הפעולה היא o(nבריבוע ) כאשר N הוא אורך הרשימה


    public static Node<Integer> uniqueList(Node<Integer> head) {
        Node<Integer> resultDummy = new Node<>(0);
        Node<Integer> resultTail = resultDummy;
        Node<Integer> current = head;
        while (current != null) {
            if (!contains(resultDummy.getNext(), current.getValue())) {
                resultTail.setNext(new Node<>(current.getValue()));
                resultTail = resultTail.getNext();
            }
            current = current.getNext();
        }
        return resultDummy.getNext();
    }
//יעילות הפעולה היא o(n) כאשר N הוא אורך הרשימה

    private static boolean contains(Node<Integer> head, int value) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == value) return true;
            current = current.getNext();
        }
        return false;
    }

//יעילות הפעולה היא o(n) כאשר N הוא אורך הרשימה

