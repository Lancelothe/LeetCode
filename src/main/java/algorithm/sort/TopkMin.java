package algorithm.sort;

/**
 * @author lancelot
 * @date 2020/3/5
 */
public class TopkMin {
    public static void main(String[] args) {
        // 源数据
        int[] data = {56, 275, 12, 6, 45, 478, 41, 1236, 456, 2, 546, 46};

        // 获取Top5
        int[] top5 = topK(data, 5);

        for (int i = 0; i < 5; i++) {
            System.out.println(top5[i]);
        }
    }

    private static int[] topK(int[] data, int k) {
        int[] topk = new int[k];
        for (int i = 0; i < k; i++) {
            topk[i] = data[i];
        }

        buildHeap(topk);
        for (int i = k; i < data.length; i++) {
            int root = getRoot(topk);
            if (data[i] < root) {
                setRoot(topk, data[i]);
            }
        }

        return topk;
    }

    private static void buildHeap(int[] data) {
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            heapify(data, i);
        }
    }

    private static void heapify(int[] data, int i) {
        int l = left(i);
        int r = right(i);

        int smallest = i;

        if (l < data.length && data[l] > data[i])
            smallest = l;

        if (r < data.length && data[r] > data[smallest])
            smallest = r;

        if (i == smallest)
            return;

        swap(data, i, smallest);

        heapify(data, smallest);
    }

    private static int right(int i) {
        return (i + 1) << 1;
    }

    private static int left(int i) {
        return ((i + 1) << 1) - 1;
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static int getRoot(int[] data) {
        return data[0];
    }

    public static void setRoot(int[] data, int root) {
        data[0] = root;
        heapify(data, 0);
    }
}
