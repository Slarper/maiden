package slarper.breast;

import net.minecraft.client.model.*;
import net.minecraft.util.math.Direction;
import slarper.customuv.CustomUv;

public class BreastEntityModel {

    public static final int TEXTURE_U_SIZE = 64;
    public static final int TEXTURE_V_SIZE = 64;


    public static TexturedModelData getTexturedModelData(){
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        root.addChild(
                "breast",
                ModelPartBuilder.create()
                        .uv(15,21)
                        .cuboid(-4F, -2F,-2.5F, 8,4,5, new Dilation(-0.1F)),
                ModelTransform.of(
                        0.0F,4F,-2F,
                        0.872665F, 0F, 0F
                )
        );
        return TexturedModelData.of(modelData, 64, 64);
    }

    public static ModelPart getModel(){
        ModelPart model = getTexturedModelData().createModel();
        ModelPart breast = model.getChild("breast");
        ModelPart.Vertex[] vertices = CustomUv.getFace(breast,0, Direction.NORTH);
        int minU = 20;
        int minV = 25;
        int maxU = 28;
        int maxV = 29;
        CustomUv.setUv(minU, minV, maxU, maxV, TEXTURE_U_SIZE, TEXTURE_V_SIZE, vertices,
                2, 3, 0, 1
                );
        return model;
    }
}
