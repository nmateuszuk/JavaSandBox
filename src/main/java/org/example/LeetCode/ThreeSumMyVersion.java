package org.example.LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSumMyVersion {
    //  public static List<List<Integer>> threeSum(int[] nums) {
    public static void threeSum(int[] nums) {

        //IntStream stream = IntStream.of(nums).distinct();
        //System.out.println(stream);

        List<int[]> combinations = Arrays.stream(nums).distinct()
                .mapToObj(a -> Arrays.stream(nums).filter(x -> x != a)
                        .mapToObj(b -> Arrays.stream(nums).filter(x -> x != b && x != a)
                                .mapToObj(c -> new int[]{a, b, c}))
                        .flatMap(x -> x))
                .flatMap(x -> x)
                .collect(Collectors.toList());

        var filtered = combinations.stream().filter(array -> array[0] + array[1] + array[2] == 0).collect(Collectors.toList());

        var sorted = filtered.stream().map(array -> Arrays.stream(array).boxed().sorted().toList()).distinct().collect(Collectors.toList());

        //filtered.forEach(array -> System.out.println(Arrays.toString(array)));
        sorted.forEach(list -> System.out.println(list));


    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, 3, 4, -4, -2};
        threeSum(nums);

    }
}
