package com.example.hash;

/**
 * ��ϣ������������ݵ�key��ϣ����洢�������У���������ǹ�ϣ��
 * ��ϣ����������С����洢������Χ�ļ�����̣����ݵ�key�����鳤��ȡģ�������
 *
 * ��ͻ���ڹ�ϣ�������м���õ������������±��Ѿ��������ڸ������±�洢�����ǹ�ϣ��ĳ�ͻ��
 * ��ͻ�����ֽ��������
 * 1�����ŵ�ַ�����ҵ�����������λ�������ݣ������ù�ϣ������õ��������±�
 * 2������ַ���������ڲ��洢���ݣ�������ͻʱ�µ�����ֱ�ӽӵ���������±���ָ��������
 *
 * ���ŵ�ַ�������ִ���ʽ��
 * 1������̽�⣺�ڹ�ϣ������ͻ�������±꿪ʼ����һ������û�����ݴ洢�������±��������ҵ��ͽ����ݲ���
 * ���ڵ����⣺�����������ʱ��̽����ҿհ�λ�õ�ʱ���ӳ���Ҳ�ᵼ�·��䲻���ȣ�����һ���־ۼ����������ݣ���һ���ֻ���ϡ�裬��������
 *
 * 2������̽�⣺�ڹ�ϣ������ͻ�������±꿪ʼ������û�����ݴ洢�������±�������������ÿ�������Ѿ������ݴ洢ʱ���Ӵ���Ҽ����
 * �����һ�β��ҵ�λ�������ݣ�����ͼӴ�4���ң��ٲ��ҵ�λ�������ݼ���ͼӴ�9���������ƣ�ֱ���ҵ��հ׵�λ�ý����ݲ���
 * ���ڵ����⣺�����������ʱ��̽����ҿհ�λ�õļ���ᳬ�����鳤��
 *
 * 3���ٹ�ϣ�����ڹ�ϣ������ͻʱ����key�ò�ͬ�Ĺ�ϣ��������һ���ϣ��������������Ϊ�������ҿհ׵�����λ��
 * �ڶ�����ϣ��������߱������ص㣺
 * �ٺ͵�һ����ϣ������ͬ
 * stepSize = constant - (key % constant)
 * constant������������1������������������
 * �ڲ������0������û�в����㷨��������ѭ����
 * ���ڵ����⣺Ҫ������ĳ�����һ������������ڶ�����ϣ��������Ĳ��������ڼ����̶���ֵ֮�е����㷨����
 *
 * ��ϣ�����ȱ�㣺
 * �ŵ㣺
 * ���롢ɾ�������ҿ��٣����۹�ϣ�����ж������ݣ������ɾ��ֻ��Ҫ�ӽ�O(1)
 * ȱ�㣺
 * ��������ģ����鴴����������չ�����鱻��������ʱ�����½�����
 * �ʺ��ڲ���Ҫ����������ݲ��ҿ�����ǰԤ����������С�����ʹ��
 */

// ʹ������ַ��ʵ�ֹ�ϣ��
public class Hash {
    private SortedList[] hashArray;
    private int arraySize;

    public Hash(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ". ");
            hashArray[i].displayList();
        }
    }

    /**
     * ��ϣ�������������ݴ�ŵ������±�����λ��
     */
    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link link) {
        int key = link.data;
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(link);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }

    static class Link {
        int data;
        Link next;

        Link(int data) {
            this.data = data;
        }

        void displayLink() {
            System.out.print(data + " ");
        }
    }

    /**
     * ÿ������Ԫ�ض���һ������
     */
    static class SortedList {
        Link first;

        void insert(Link link) {
            int key = link.data;
            Link previous = null;
            Link current = first;

            while (current != null && key > current.data) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                first = link;
            } else {
                previous.next = link;
            }
            link.next = current;
        }

        void delete(int key) {
            Link previous = null;
            Link current = first;

            while (current != null && key != current.data) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
        }

        Link find(int key) {
            Link current = first;

            while (current != null && current.data <= key) {
                if (current.data == key) {
                    return current;
                }
                current = current.next;
            }

            return null;
        }

        void displayList() {
            System.out.print("List(first-->last): ");
            Link current = first;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
            System.out.println(" ");
        }
    }
}
