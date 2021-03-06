package com.mysema.query.jpa.domain.sql;

import javax.annotation.Generated;

import com.mysema.query.sql.ColumnMetadata;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * SGeneratedKeys is a Querydsl query type for SGeneratedKeys
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class SGeneratedKeys extends com.mysema.query.sql.RelationalPathBase<SGeneratedKeys> {

    private static final long serialVersionUID = 379851474;

    public static final SGeneratedKeys generatedKeys = new SGeneratedKeys("GENERATED_KEYS");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<SGeneratedKeys> primary = createPrimaryKey(id);

    public SGeneratedKeys(String variable) {
        super(SGeneratedKeys.class, forVariable(variable), "", "GENERATED_KEYS");
        addMetadata();
    }

    public SGeneratedKeys(String variable, String schema, String table) {
        super(SGeneratedKeys.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public SGeneratedKeys(Path<? extends SGeneratedKeys> path) {
        super(path.getType(), path.getMetadata(), "", "GENERATED_KEYS");
        addMetadata();
    }

    public SGeneratedKeys(PathMetadata<?> metadata) {
        super(SGeneratedKeys.class, metadata, "", "GENERATED_KEYS");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(4).withSize(10).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(12).withSize(30));
    }

}

