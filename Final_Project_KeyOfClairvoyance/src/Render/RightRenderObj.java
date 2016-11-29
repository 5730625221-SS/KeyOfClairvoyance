package Render;

import java.util.ArrayList;
import java.util.List;

public class RightRenderObj {

	public static final RightRenderObj instance = new RightRenderObj();
	public List<Renderable> entities;

	public static RightRenderObj getInstance() {
		return instance;
	}

	public RightRenderObj() {
		entities = new ArrayList<Renderable>();
	}

	public void add(Renderable entity) {
		entities.add(entity);
	}

	public List<Renderable> getRenderableList() {
		return entities;
	}

}
