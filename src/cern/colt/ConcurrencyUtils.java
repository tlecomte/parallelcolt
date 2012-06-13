/* ***** BEGIN LICENSE BLOCK *****
* Version: MPL 1.1/GPL 2.0/LGPL 2.1
*
* The contents of this file are subject to the Mozilla Public License Version
* 1.1 (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
* http://www.mozilla.org/MPL/
*
* Software distributed under the License is distributed on an "AS IS" basis,
* WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
* for the specific language governing rights and limitations under the
* License.
*
* The Original Code is Parallel Colt.
*
* The Initial Developer of the Original Code is
* Piotr Wendykier, Emory University.
* Portions created by the Initial Developer are Copyright (C) 2007-2009
* the Initial Developer. All Rights Reserved.
*
* Alternatively, the contents of this file may be used under the terms of
* either the GNU General Public License Version 2 or later (the "GPL"), or
* the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
* in which case the provisions of the GPL or the LGPL are applicable instead
* of those above. If you wish to allow use of your version of this file only
* under the terms of either the GPL or the LGPL, and not to allow others to
* use your version of this file under the terms of the MPL, indicate your
* decision by deleting the provisions above and replace them with the notice
* and other provisions required by the GPL or the LGPL. If you do not delete
* the provisions above, a recipient may use your version of this file under
* the terms of any one of the MPL, the GPL or the LGPL.
*
* ***** END LICENSE BLOCK ***** */

package cern.colt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import cern.colt.function.tdcomplex.DComplexDComplexDComplexFunction;
import cern.colt.function.tdouble.DoubleDoubleFunction;
import cern.colt.function.tfcomplex.FComplexFComplexFComplexFunction;
import cern.colt.function.tfloat.FloatFloatFunction;
import cern.colt.function.tint.IntIntFunction;
import cern.colt.function.tlong.LongLongFunction;
import cern.colt.function.tobject.ObjectObjectFunction;

/**
 * Concurrency utilities.
 * This class wraps ConcurrencyUtils from JTransforms, and adds
 * additional waitForCompletion methods.
 * 
 * @author Piotr Wendykier (piotr.wendykier@gmail.com)
 */
public class ConcurrencyUtils
{
    /**
     * Returns the number of available processors.
     * 
     * @return number of available processors
     */
    public static int getNumberOfProcessors() {
        return edu.emory.mathcs.utils.ConcurrencyUtils.getNumberOfProcessors();
    }

    /**
     * Returns the current number of threads.
     * 
     * @return the current number of threads.
     */
    public static int getNumberOfThreads() {
        return edu.emory.mathcs.utils.ConcurrencyUtils.getNumberOfThreads();
    }

    /**
     * Sets the number of threads.
     * 
     * @param n
     */
    public static void setNumberOfThreads(int n) {
        edu.emory.mathcs.utils.ConcurrencyUtils.setNumberOfThreads(n);
    }
    
    /**
     * Returns the minimal size of 1D data for which threads are used.
     * 
     * @return the minimal size of 1D data for which threads are used
     */
    public static int getThreadsBeginN_1D() {
        return edu.emory.mathcs.utils.ConcurrencyUtils.getThreadsBeginN_1D();
    }

    /**
     * Returns the minimal size of 1D data for which two threads are used.
     * 
     * @return the minimal size of 1D data for which two threads are used
     */
    public static int getThreadsBeginN_1D_FFT_2Threads() {
        return edu.emory.mathcs.utils.ConcurrencyUtils.getThreadsBeginN_1D_FFT_2Threads();
    }

    /**
     * Returns the minimal size of 1D data for which four threads are used.
     * 
     * @return the minimal size of 1D data for which four threads are used
     */
    public static int getThreadsBeginN_1D_FFT_4Threads() {
        return edu.emory.mathcs.utils.ConcurrencyUtils.getThreadsBeginN_1D_FFT_4Threads();
    }

    /**
     * Returns the minimal size of 2D data for which threads are used.
     * 
     * @return the minimal size of 2D data for which threads are used
     */
    public static int getThreadsBeginN_2D() {
        return edu.emory.mathcs.utils.ConcurrencyUtils.getThreadsBeginN_2D();
    }

    /**
     * Returns the minimal size of 3D data for which threads are used.
     * 
     * @return the minimal size of 3D data for which threads are used
     */
    public static int getThreadsBeginN_3D() {
        return edu.emory.mathcs.utils.ConcurrencyUtils.getThreadsBeginN_3D();
    }

    /**
     * Sets the minimal size of 1D data for which two threads are used.
     * 
     * @param n
     *            the minimal size of 1D data for which two threads are used
     */
    public static void setThreadsBeginN_1D_FFT_2Threads(int n) {
        edu.emory.mathcs.utils.ConcurrencyUtils.setThreadsBeginN_1D_FFT_2Threads(n);
    }

    /**
     * Sets the minimal size of 1D data for which four threads are used.
     * 
     * @param n
     *            the minimal size of 1D data for which four threads are used
     */
    public static void setThreadsBeginN_1D_FFT_4Threads(int n) {
        edu.emory.mathcs.utils.ConcurrencyUtils.setThreadsBeginN_1D_FFT_4Threads(n);
    }

    /**
     * Sets the minimal size of 1D data for which threads are used.
     * 
     * @param n
     *            the minimal size of 1D data for which threads are used
     */
    public static void setThreadsBeginN_1D(int n) {
        edu.emory.mathcs.utils.ConcurrencyUtils.setThreadsBeginN_1D(n);
    }

    /**
     * Sets the minimal size of 2D data for which threads are used.
     * 
     * @param n
     *            the minimal size of 2D data for which threads are used
     */
    public static void setThreadsBeginN_2D(int n) {
        edu.emory.mathcs.utils.ConcurrencyUtils.setThreadsBeginN_2D(n);
    }

    /**
     * Sets the minimal size of 3D data for which threads are used.
     * 
     * @param n
     *            the minimal size of 3D data for which threads are used
     */
    public static void setThreadsBeginN_3D(int n) {
        edu.emory.mathcs.utils.ConcurrencyUtils.setThreadsBeginN_3D(n);
    }

    /**
     * Resets the minimal size of 1D data for which two and four threads are
     * used.
     */
    public static void resetThreadsBeginN_FFT() {
        edu.emory.mathcs.utils.ConcurrencyUtils.resetThreadsBeginN_FFT();
    }

    /**
     * Resets the minimal size of 1D, 2D and 3D data for which threads are used.
     */
    public static void resetThreadsBeginN() {
        edu.emory.mathcs.utils.ConcurrencyUtils.resetThreadsBeginN();
    }    

    /**
     * Causes the currently executing thread to sleep (temporarily cease
     * execution) for the specified number of milliseconds.
     * 
     * @param millis
     */
    public static void sleep(long millis) {
        edu.emory.mathcs.utils.ConcurrencyUtils.sleep(millis);
    }

    /**
     * Submits a value-returning task for execution and returns a Future
     * representing the pending results of the task.
     * 
     * @param <T>
     * @param task
     *            task for execution
     * @return a handle to the task submitted for execution
     */
    public static <T> Future<T> submit(Callable<T> task) {
        return edu.emory.mathcs.utils.ConcurrencyUtils.submit(task);
    }

    /**
     * Submits a Runnable task for execution and returns a Future representing
     * that task.
     * 
     * @param task
     *            task for execution
     * @return a handle to the task submitted for execution
     */
    public static Future<?> submit(Runnable task) {
        return edu.emory.mathcs.utils.ConcurrencyUtils.submit(task);
    }
    
    /**
     * Waits for all threads to complete computation.
     * 
     * @param futures
     *            handles to running threads
     */
    public static void waitForCompletion(Future<?>[] futures) {
        edu.emory.mathcs.utils.ConcurrencyUtils.waitForCompletion(futures);
    }
    
    /**
     * Waits for all threads to complete computation and aggregates the result.
     * 
     * @param futures
     *            handles to running threads
     * @param aggr
     *            an aggregation function
     * @return the result of aggregation
     */
    public static double waitForCompletion(Future<?>[] futures, DoubleDoubleFunction aggr) {
        int size = futures.length;
        Double[] results = new Double[size];
        double a = 0;
        try {
            for (int j = 0; j < size; j++) {
                results[j] = (Double) futures[j].get();
            }
            a = results[0];
            for (int j = 1; j < size; j++) {
                a = aggr.apply(a, results[j]);
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Waits for all threads to complete computation and aggregates the result.
     * 
     * @param futures
     *            handles to running threads
     * @param aggr
     *            an aggregation function
     * @return the result of aggregation
     */
    public static int waitForCompletion(Future<?>[] futures, IntIntFunction aggr) {
        int size = futures.length;
        Integer[] results = new Integer[size];
        int a = 0;
        try {
            for (int j = 0; j < size; j++) {
                results[j] = (Integer) futures[j].get();
            }
            a = results[0];
            for (int j = 1; j < size; j++) {
                a = aggr.apply(a, results[j]);
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Waits for all threads to complete computation and aggregates the result.
     * 
     * @param futures
     *            handles to running threads
     * @param aggr
     *            an aggregation function
     * @return the result of aggregation
     */
    public static long waitForCompletion(Future<?>[] futures, LongLongFunction aggr) {
        int size = futures.length;
        Long[] results = new Long[size];
        long a = 0;
        try {
            for (int j = 0; j < size; j++) {
                results[j] = (Long) futures[j].get();
            }
            a = results[0];
            for (int j = 1; j < size; j++) {
                a = aggr.apply(a, results[j]);
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Waits for all threads to complete computation and aggregates the result.
     * 
     * @param futures
     *            handles to running threads
     * @param aggr
     *            an aggregation function
     * @return the result of aggregation
     */
    public static Object waitForCompletion(Future<?>[] futures, ObjectObjectFunction aggr) {
        int size = futures.length;
        Object[] results = new Object[size];
        Object a = null;
        try {
            for (int j = 0; j < size; j++) {
                results[j] = (Integer) futures[j].get();
            }
            a = results[0];
            for (int j = 1; j < size; j++) {
                a = aggr.apply(a, results[j]);
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Waits for all threads to complete computation and aggregates the result.
     * 
     * @param futures
     *            handles to running threads
     * @param aggr
     *            an aggregation function
     * @return the result of aggregation
     */
    public static double[] waitForCompletion(Future<?>[] futures, DComplexDComplexDComplexFunction aggr) {
        int size = futures.length;
        double[][] results = new double[size][2];
        double[] a = null;
        try {
            for (int j = 0; j < size; j++) {
                results[j] = (double[]) futures[j].get();
            }
            a = results[0];
            for (int j = 1; j < size; j++) {
                a = aggr.apply(a, results[j]);
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Waits for all threads to complete computation and aggregates the result.
     * 
     * @param futures
     *            handles to running threads
     * @param aggr
     *            an aggregation function
     * @return the result of aggregation
     */
    public static float[] waitForCompletion(Future<?>[] futures, FComplexFComplexFComplexFunction aggr) {
        int size = futures.length;
        float[][] results = new float[size][2];
        float[] a = null;
        try {
            for (int j = 0; j < size; j++) {
                results[j] = (float[]) futures[j].get();
            }
            a = results[0];
            for (int j = 1; j < size; j++) {
                a = aggr.apply(a, results[j]);
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * Waits for all threads to complete computation and aggregates the result.
     * 
     * @param futures
     *            handles to running threads
     * @param aggr
     *            an aggregation function
     * @return the result of aggregation
     */
    public static float waitForCompletion(Future<?>[] futures, FloatFloatFunction aggr) {
        int size = futures.length;
        Float[] results = new Float[size];
        float a = 0;
        try {
            for (int j = 0; j < size; j++) {
                results[j] = (Float) futures[j].get();
            }
            a = results[0];
            for (int j = 1; j < size; j++) {
                a = aggr.apply(a, results[j]);
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }
    
    /**
     * Returns the closest power-of-two number greater than or equal to x.
     * 
     * @param x
     * @return the closest power-of-two number greater than or equal to x
     */
    public static int nextPow2(int x) {
        return edu.emory.mathcs.utils.ConcurrencyUtils.nextPow2(x);
    }

    /**
     * Returns the closest power-of-two number less than or equal to x.
     * 
     * @param x
     * @return the closest power-of-two number less then or equal to x
     */
    public static int prevPow2(int x) {
        return edu.emory.mathcs.utils.ConcurrencyUtils.prevPow2(x);
    }

    /**
     * Checks if x is a power-of-two number.
     * 
     * @param x
     * @return true if x is a power-of-two number
     */
    public static boolean isPowerOf2(int x) {
        return edu.emory.mathcs.utils.ConcurrencyUtils.isPowerOf2(x);
    }
    
    public static int extendDimension(int x) {
        return edu.emory.mathcs.utils.ConcurrencyUtils.extendDimension(x);
    }

    public static int nextExp2(int n) {
        return edu.emory.mathcs.utils.ConcurrencyUtils.nextExp2(n);
    }
}
