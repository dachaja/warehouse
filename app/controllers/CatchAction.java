package controllers;

import play.Logger;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;
import utils.ExceptionMailer;

public class CatchAction extends Action.Simple{
	@Override
	public Promise<Result> call(Context ctx) {
		try {
			Logger.debug(ctx.toString());
			return delegate.call(ctx);
		} catch(Throwable e) {
			ExceptionMailer.send(e);
			throw new RuntimeException(e);
		}
	}

}
