
package com.evancharlton.mileage.charts;

import com.evancharlton.mileage.R;
import com.evancharlton.mileage.dao.Vehicle;

import android.database.Cursor;

public class MaximumPriceChart extends PriceChart {
    @Override
    protected String getAxisTitle() {
        return getString(R.string.stat_max_price);
    }

    @Override
    protected void processCursor(LineChartGenerator generator, Cursor cursor, Vehicle vehicle) {
        int num = 0;
        double maximum_price = -10000;
        while (cursor.isAfterLast() == false) {
            if (generator.isCancelled()) {
                break;
            }
            double price = cursor.getDouble(1);
            if (price > maximum_price) {
                maximum_price = price;
            }
            addPoint(cursor.getLong(0), maximum_price);
            generator.update(num++);
            cursor.moveToNext();
        }
    }
}
