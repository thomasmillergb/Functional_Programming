package Basics;


import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.math.LongMath;

import java.util.Collection;
import java.util.List;


/**
 * Created by Thomas on 27/03/2016.
 */
public class NumberFun {
    public NumberFun() {
    }

    public List<Long> function(List<List<Long>> words) {

        Iterable<Long> transform = Iterables.transform(words, biggest);
        final List<Long> result = FluentIterable
                .from(words)
                .transform(biggest)
                .filter(lessThanZero)
                .toList();
        return null;
    }

    private static Function<List<Long>, Long> biggest = new Function<List<Long>, Long>() {

        @Override
        public Long apply(List<Long> vals) {
            Long smallest = Long.MAX_VALUE;
            Collection<Long> result = Collections2.filter(vals, lessThanZero);
            for (Long temp : result) {
                if (smallest > temp) {
                    smallest = temp;
                }
            }
            if(smallest.equals(Long.MAX_VALUE))
                return new Long(0);
            return smallest;
        }

    };

    private static Predicate<Long> lessThanZero = new Predicate<Long>() {
        @Override
        public boolean apply(Long aLong) {
            return aLong < 0;
        }
    };

    public static void main(String[] args) {
        NumberFun m = new NumberFun();
        List<List<Long>> lists= Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<Long> longs = Lists.newArrayList();
            for (long j = -5l; j < 10l; j++) {
                longs.add(LongMath.pow(j,i));
            }
            lists.add(longs);
        }

        m.function(lists);
    }


}
