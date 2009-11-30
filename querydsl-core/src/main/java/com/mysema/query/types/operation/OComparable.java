/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.types.operation;

import java.util.Arrays;
import java.util.List;

import com.mysema.query.types.Visitor;
import com.mysema.query.types.expr.EComparable;
import com.mysema.query.types.expr.Expr;

/**
 * OComparable represents Comparable operations
 * 
 * @author tiwe
 * 
 * @param <OpType>
 * @param <D>
 */
@SuppressWarnings("serial")
public class OComparable<OpType, D extends Comparable<?>> extends
        EComparable<D> implements Operation<OpType, D> {
    
    /**
     * Factory method
     * 
     * @param <O>
     * @param <D>
     * @param type
     * @param op
     * @param args
     * @return
     */
    public static <O,D extends Comparable<?>> EComparable<D> create(Class<D> type, Operator<O> op, Expr<?>... args){
        return new OComparable<O,D>(type, op, args);
    }
    
    private final Operation<OpType, D> opMixin;
    
    OComparable(Class<D> type, Operator<OpType> op, Expr<?>... args) {
        this(type, op, Arrays.asList(args));
    }

    OComparable(Class<D> type, Operator<OpType> op, List<Expr<?>> args) {
        super(type);
        this.opMixin = new OperationMixin<OpType, D>(this, op, args);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);        
    }

    @Override
    public EComparable<D> asExpr() {
        return this;
    }
    
    @Override
    public Expr<?> getArg(int index) {
        return opMixin.getArg(index);
    }

    @Override
    public List<Expr<?>> getArgs() {
        return opMixin.getArgs();
    }

    @Override
    public Operator<OpType> getOperator() {
        return opMixin.getOperator();
    }
    
}