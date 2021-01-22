/*
 * This file is generated by jOOQ.
*/
package jsl.utilities.jsldbsrc.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jsl.utilities.jsldbsrc.JslDb;
import jsl.utilities.jsldbsrc.Keys;
import jsl.utilities.jsldbsrc.tables.records.SimulationRunRecord;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class SimulationRun extends TableImpl<SimulationRunRecord> {

    private static final long serialVersionUID = -572861285;

    /**
     * The reference instance of <code>JSL_DB.SIMULATION_RUN</code>
     */
    public static final SimulationRun SIMULATION_RUN = new SimulationRun();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SimulationRunRecord> getRecordType() {
        return SimulationRunRecord.class;
    }

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.ID</code>.
     */
    public final TableField<SimulationRunRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.SIM_NAME</code>.
     */
    public final TableField<SimulationRunRecord, String> SIM_NAME = createField("SIM_NAME", org.jooq.impl.SQLDataType.VARCHAR(510).nullable(false), this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.MODEL_NAME</code>.
     */
    public final TableField<SimulationRunRecord, String> MODEL_NAME = createField("MODEL_NAME", org.jooq.impl.SQLDataType.VARCHAR(510).nullable(false), this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.EXP_NAME</code>.
     */
    public final TableField<SimulationRunRecord, String> EXP_NAME = createField("EXP_NAME", org.jooq.impl.SQLDataType.VARCHAR(510).nullable(false), this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.EXP_START_TIME_STAMP</code>.
     */
    public final TableField<SimulationRunRecord, Timestamp> EXP_START_TIME_STAMP = createField("EXP_START_TIME_STAMP", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.EXP_END_TIME_STAMP</code>.
     */
    public final TableField<SimulationRunRecord, Timestamp> EXP_END_TIME_STAMP = createField("EXP_END_TIME_STAMP", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.NUM_REPS</code>.
     */
    public final TableField<SimulationRunRecord, Integer> NUM_REPS = createField("NUM_REPS", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.LAST_REP</code>.
     */
    public final TableField<SimulationRunRecord, Integer> LAST_REP = createField("LAST_REP", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.LENGTH_OF_REP</code>.
     */
    public final TableField<SimulationRunRecord, Double> LENGTH_OF_REP = createField("LENGTH_OF_REP", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.LENGTH_OF_WARM_UP</code>.
     */
    public final TableField<SimulationRunRecord, Double> LENGTH_OF_WARM_UP = createField("LENGTH_OF_WARM_UP", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.HAS_MORE_REPS</code>.
     */
    public final TableField<SimulationRunRecord, Boolean> HAS_MORE_REPS = createField("HAS_MORE_REPS", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.REP_ALLOWED_EXEC_TIME</code>.
     */
    public final TableField<SimulationRunRecord, Long> REP_ALLOWED_EXEC_TIME = createField("REP_ALLOWED_EXEC_TIME", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.REP_INIT_OPTION</code>.
     */
    public final TableField<SimulationRunRecord, Boolean> REP_INIT_OPTION = createField("REP_INIT_OPTION", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.RESET_START_STREAM_OPTION</code>.
     */
    public final TableField<SimulationRunRecord, Boolean> RESET_START_STREAM_OPTION = createField("RESET_START_STREAM_OPTION", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.ANTITHETIC_OPTION</code>.
     */
    public final TableField<SimulationRunRecord, Boolean> ANTITHETIC_OPTION = createField("ANTITHETIC_OPTION", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.ADV_NEXT_SUB_STREAM_OPTION</code>.
     */
    public final TableField<SimulationRunRecord, Boolean> ADV_NEXT_SUB_STREAM_OPTION = createField("ADV_NEXT_SUB_STREAM_OPTION", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>JSL_DB.SIMULATION_RUN.NUM_STREAM_ADVANCES</code>.
     */
    public final TableField<SimulationRunRecord, Integer> NUM_STREAM_ADVANCES = createField("NUM_STREAM_ADVANCES", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>JSL_DB.SIMULATION_RUN</code> table reference
     */
    public SimulationRun() {
        this(DSL.name("SIMULATION_RUN"), null);
    }

    /**
     * Create an aliased <code>JSL_DB.SIMULATION_RUN</code> table reference
     */
    public SimulationRun(String alias) {
        this(DSL.name(alias), SIMULATION_RUN);
    }

    /**
     * Create an aliased <code>JSL_DB.SIMULATION_RUN</code> table reference
     */
    public SimulationRun(Name alias) {
        this(alias, SIMULATION_RUN);
    }

    private SimulationRun(Name alias, Table<SimulationRunRecord> aliased) {
        this(alias, aliased, null);
    }

    private SimulationRun(Name alias, Table<SimulationRunRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return JslDb.JSL_DB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SimulationRunRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SIMULATION_RUN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SimulationRunRecord> getPrimaryKey() {
        return Keys.SQL190415110855730;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SimulationRunRecord>> getKeys() {
        return Arrays.<UniqueKey<SimulationRunRecord>>asList(Keys.SQL190415110855730, Keys.SR_NAME_EXP_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRun as(String alias) {
        return new SimulationRun(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimulationRun as(Name alias) {
        return new SimulationRun(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SimulationRun rename(String name) {
        return new SimulationRun(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SimulationRun rename(Name name) {
        return new SimulationRun(name, null);
    }
}
