/*
 * This file is generated by jOOQ.
*/
package jsl.utilities.jsldbsrc.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import jsl.utilities.jsldbsrc.tables.SimulationRun;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SimulationRunRecord extends UpdatableRecordImpl<SimulationRunRecord> implements Record17<Integer, String, String, String, Timestamp, Timestamp, Integer, Integer, Double, Double, Boolean, Long, Boolean, Boolean, Boolean, Boolean, Integer> {

    private static final long serialVersionUID = 2050666897;

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.SIM_NAME</code>.
     */
    public void setSimName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.SIM_NAME</code>.
     */
    public String getSimName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.MODEL_NAME</code>.
     */
    public void setModelName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.MODEL_NAME</code>.
     */
    public String getModelName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.EXP_NAME</code>.
     */
    public void setExpName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.EXP_NAME</code>.
     */
    public String getExpName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.EXP_START_TIME_STAMP</code>.
     */
    public void setExpStartTimeStamp(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.EXP_START_TIME_STAMP</code>.
     */
    public Timestamp getExpStartTimeStamp() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.EXP_END_TIME_STAMP</code>.
     */
    public void setExpEndTimeStamp(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.EXP_END_TIME_STAMP</code>.
     */
    public Timestamp getExpEndTimeStamp() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.NUM_REPS</code>.
     */
    public void setNumReps(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.NUM_REPS</code>.
     */
    public Integer getNumReps() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.LAST_REP</code>.
     */
    public void setLastRep(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.LAST_REP</code>.
     */
    public Integer getLastRep() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.LENGTH_OF_REP</code>.
     */
    public void setLengthOfRep(Double value) {
        set(8, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.LENGTH_OF_REP</code>.
     */
    public Double getLengthOfRep() {
        return (Double) get(8);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.LENGTH_OF_WARM_UP</code>.
     */
    public void setLengthOfWarmUp(Double value) {
        set(9, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.LENGTH_OF_WARM_UP</code>.
     */
    public Double getLengthOfWarmUp() {
        return (Double) get(9);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.HAS_MORE_REPS</code>.
     */
    public void setHasMoreReps(Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.HAS_MORE_REPS</code>.
     */
    public Boolean getHasMoreReps() {
        return (Boolean) get(10);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.REP_ALLOWED_EXEC_TIME</code>.
     */
    public void setRepAllowedExecTime(Long value) {
        set(11, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.REP_ALLOWED_EXEC_TIME</code>.
     */
    public Long getRepAllowedExecTime() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.REP_INIT_OPTION</code>.
     */
    public void setRepInitOption(Boolean value) {
        set(12, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.REP_INIT_OPTION</code>.
     */
    public Boolean getRepInitOption() {
        return (Boolean) get(12);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.RESET_START_STREAM_OPTION</code>.
     */
    public void setResetStartStreamOption(Boolean value) {
        set(13, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.RESET_START_STREAM_OPTION</code>.
     */
    public Boolean getResetStartStreamOption() {
        return (Boolean) get(13);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.ANTITHETIC_OPTION</code>.
     */
    public void setAntitheticOption(Boolean value) {
        set(14, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.ANTITHETIC_OPTION</code>.
     */
    public Boolean getAntitheticOption() {
        return (Boolean) get(14);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.ADV_NEXT_SUB_STREAM_OPTION</code>.
     */
    public void setAdvNextSubStreamOption(Boolean value) {
        set(15, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.ADV_NEXT_SUB_STREAM_OPTION</code>.
     */
    public Boolean getAdvNextSubStreamOption() {
        return (Boolean) get(15);
    }

    /**
     * Setter for <code>JSL_DB.SIMULATION_RUN.NUM_STREAM_ADVANCES</code>.
     */
    public void setNumStreamAdvances(Integer value) {
        set(16, value);
    }

    /**
     * Getter for <code>JSL_DB.SIMULATION_RUN.NUM_STREAM_ADVANCES</code>.
     */
    public Integer getNumStreamAdvances() {
        return (Integer) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<Integer, String, String, String, Timestamp, Timestamp, Integer, Integer, Double, Double, Boolean, Long, Boolean, Boolean, Boolean, Boolean, Integer> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<Integer, String, String, String, Timestamp, Timestamp, Integer, Integer, Double, Double, Boolean, Long, Boolean, Boolean, Boolean, Boolean, Integer> valuesRow() {
        return (Row17) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return SimulationRun.SIMULATION_RUN.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SimulationRun.SIMULATION_RUN.SIM_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SimulationRun.SIMULATION_RUN.MODEL_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SimulationRun.SIMULATION_RUN.EXP_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return SimulationRun.SIMULATION_RUN.EXP_START_TIME_STAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return SimulationRun.SIMULATION_RUN.EXP_END_TIME_STAMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return SimulationRun.SIMULATION_RUN.NUM_REPS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return SimulationRun.SIMULATION_RUN.LAST_REP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field9() {
        return SimulationRun.SIMULATION_RUN.LENGTH_OF_REP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field10() {
        return SimulationRun.SIMULATION_RUN.LENGTH_OF_WARM_UP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field11() {
        return SimulationRun.SIMULATION_RUN.HAS_MORE_REPS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field12() {
        return SimulationRun.SIMULATION_RUN.REP_ALLOWED_EXEC_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field13() {
        return SimulationRun.SIMULATION_RUN.REP_INIT_OPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field14() {
        return SimulationRun.SIMULATION_RUN.RESET_START_STREAM_OPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field15() {
        return SimulationRun.SIMULATION_RUN.ANTITHETIC_OPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field16() {
        return SimulationRun.SIMULATION_RUN.ADV_NEXT_SUB_STREAM_OPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field17() {
        return SimulationRun.SIMULATION_RUN.NUM_STREAM_ADVANCES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSimName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getModelName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getExpName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getExpStartTimeStamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getExpEndTimeStamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getNumReps();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getLastRep();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component9() {
        return getLengthOfRep();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component10() {
        return getLengthOfWarmUp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component11() {
        return getHasMoreReps();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component12() {
        return getRepAllowedExecTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component13() {
        return getRepInitOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component14() {
        return getResetStartStreamOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component15() {
        return getAntitheticOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component16() {
        return getAdvNextSubStreamOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component17() {
        return getNumStreamAdvances();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSimName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getModelName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getExpName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getExpStartTimeStamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getExpEndTimeStamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getNumReps();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getLastRep();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value9() {
        return getLengthOfRep();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value10() {
        return getLengthOfWarmUp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value11() {
        return getHasMoreReps();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value12() {
        return getRepAllowedExecTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value13() {
        return getRepInitOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value14() {
        return getResetStartStreamOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value15() {
        return getAntitheticOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value16() {
        return getAdvNextSubStreamOption();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value17() {
        return getNumStreamAdvances();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value2(String value) {
        setSimName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value3(String value) {
        setModelName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value4(String value) {
        setExpName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value5(Timestamp value) {
        setExpStartTimeStamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value6(Timestamp value) {
        setExpEndTimeStamp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value7(Integer value) {
        setNumReps(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value8(Integer value) {
        setLastRep(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value9(Double value) {
        setLengthOfRep(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value10(Double value) {
        setLengthOfWarmUp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value11(Boolean value) {
        setHasMoreReps(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value12(Long value) {
        setRepAllowedExecTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value13(Boolean value) {
        setRepInitOption(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value14(Boolean value) {
        setResetStartStreamOption(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value15(Boolean value) {
        setAntitheticOption(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value16(Boolean value) {
        setAdvNextSubStreamOption(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord value17(Integer value) {
        setNumStreamAdvances(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRunRecord values(Integer value1, String value2, String value3, String value4, Timestamp value5, Timestamp value6, Integer value7, Integer value8, Double value9, Double value10, Boolean value11, Long value12, Boolean value13, Boolean value14, Boolean value15, Boolean value16, Integer value17) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SimulationRunRecord
     */
    public SimulationRunRecord() {
        super(SimulationRun.SIMULATION_RUN);
    }

    /**
     * Create a detached, initialised SimulationRunRecord
     */
    public SimulationRunRecord(Integer id, String simName, String modelName, String expName, Timestamp expStartTimeStamp, Timestamp expEndTimeStamp, Integer numReps, Integer lastRep, Double lengthOfRep, Double lengthOfWarmUp, Boolean hasMoreReps, Long repAllowedExecTime, Boolean repInitOption, Boolean resetStartStreamOption, Boolean antitheticOption, Boolean advNextSubStreamOption, Integer numStreamAdvances) {
        super(SimulationRun.SIMULATION_RUN);

        set(0, id);
        set(1, simName);
        set(2, modelName);
        set(3, expName);
        set(4, expStartTimeStamp);
        set(5, expEndTimeStamp);
        set(6, numReps);
        set(7, lastRep);
        set(8, lengthOfRep);
        set(9, lengthOfWarmUp);
        set(10, hasMoreReps);
        set(11, repAllowedExecTime);
        set(12, repInitOption);
        set(13, resetStartStreamOption);
        set(14, antitheticOption);
        set(15, advNextSubStreamOption);
        set(16, numStreamAdvances);
    }
}