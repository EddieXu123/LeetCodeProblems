class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
            return list;
        }
        return helperList(list, rowIndex);
    }
    
    public List<Integer> helperList(List<Integer> list, int rowIndex) {
        if (rowIndex == 0) return list;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < list.size(); i++) {
            result.add(i, list.get(i - 1)+list.get(i));
        }
        result.add(1);
        return helperList(result, rowIndex - 1);
    }
}
