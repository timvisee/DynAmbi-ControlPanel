/*
 * Copyright (c) Tim Visee 2016. All rights reserved.
 *
 * @author Tim Visee
 * @website http://timvisee.com/
 *
 * Open Source != No Copyright
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package com.timvisee.dynambi.canvas;

import com.timvisee.dynambi.math.Point;

public class CanvasPixel {

    /**
     * Canvas pixel point / location.
     */
    private Point point;

    /**
     * Define whether this canvas pixel is pinned or not.
     */
    private boolean pinned = false;

    /**
     * Get the pixel point.
     *
     * @return Pixel point.
     */
    public Point getPoint() {
        return this.point;
    }

    /**
     * Set the pixel point.
     * This won't pin the pixel.
     *
     * @param point Pixel point.
     */
    public void setPoint(Point point) {
        setPoint(point, false);
    }

    /**
     * Set the pixel point.
     *
     * @param point Pixel point.
     */
    public void setPoint(Point point, boolean pin) {
        // Set the point
        this.point = point;

        // Pin the canvas pixel
        setPinned(true);
    }

    /**
     * Check whether this pixel is pinned.
     *
     * @return True if pinned, false if not.
     */
    public boolean isPinned() {
        return this.pinned;
    }

    /**
     * Set whether this pixel is pinned.
     *
     * @param pinned True if pinned, false if not.
     */
    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }
}
